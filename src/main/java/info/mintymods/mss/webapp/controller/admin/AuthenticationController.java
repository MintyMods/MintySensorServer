package info.mintymods.mss.webapp.controller.admin;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import info.mintymods.mss.webapp.domain.Account;
import info.mintymods.mss.webapp.dto.FailedResult;
import info.mintymods.mss.webapp.dto.RequestResult;
import info.mintymods.mss.webapp.dto.SuccessfulResult;
import info.mintymods.mss.webapp.enums.MessageKey;
import info.mintymods.mss.webapp.form.SignupForm;
import info.mintymods.mss.webapp.service.AccountService;
import info.mintymods.mss.webapp.service.MessageSourceService;

@Controller
public class AuthenticationController {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
	public static final String SPRING_SECURITY_LAST_EXCEPTION = "SPRING_SECURITY_LAST_EXCEPTION";
	public static final String VIEW_LOGIN = "login";
	public static final String VIEW_LOGIN_REDIRECT = "/login/form";
	public static final String VIEW_SIGNUP = "signup";
	public static final String VIEW_SIGNUP_REDIRECT = "/admin/signup";

	@Autowired
	private AccountService accountService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MessageSourceService messageSourceService;

	@GetMapping("/login/form")
	public ModelAndView loginForm(HttpServletRequest request, Map<String, Object> model, String error, Integer type) {
		if (StringUtils.isNotEmpty(error)) {
			setErrorCondition(request, model, error, type);
		}
		if (accountService.getCount() == 0) {
			return new ModelAndView(new RedirectView(VIEW_SIGNUP_REDIRECT));
		} else {
			return new ModelAndView(VIEW_LOGIN, model);
		}
	}

	private void setErrorCondition(HttpServletRequest request, Map<String, Object> model, String error, Integer type) {
		HttpSession session = request.getSession();
		AuthenticationException exception = (AuthenticationException) session
				.getAttribute(SPRING_SECURITY_LAST_EXCEPTION);
		Optional.ofNullable(exception)
				.ifPresent(authenticatonException -> model.put("errorMessage", authenticatonException.getMessage()));
		log.debug("error : {}, type : {}, SPRING_SECURITY_LAST_EXCEPTION : {}", error, type,
				session.getAttribute(SPRING_SECURITY_LAST_EXCEPTION));
		model.put("error", BooleanUtils.toBoolean(error));
	}

	@GetMapping("/admin/signup")
	public ModelAndView signupForm() {
		if (accountService.getCount() == 0) {
			return new ModelAndView(VIEW_SIGNUP);
		} else {
			return new ModelAndView(new RedirectView(VIEW_LOGIN_REDIRECT));
		}
	}

	@PostMapping("/admin/signup")
	@ResponseBody
	public RequestResult signup(@Valid SignupForm signupForm, BindingResult bindingResult) throws BindException {
		if (accountService.getCount() == 0) {
			if (bindingResult.hasErrors()) {
				return new FailedResult(messageSourceService.getMessage(MessageKey.VALIDATION_FAILED), bindingResult);
			} else {
				Account account = modelMapper.map(signupForm, Account.class);
				Optional<Account> optionalAccount = Optional.ofNullable(accountService.insertAdmin(account));
				if (optionalAccount.isPresent()) {
					return new SuccessfulResult(messageSourceService.getMessage(MessageKey.ADMIN_CREATED_SUCCESSFULLY));
				} else {
					return new FailedResult(messageSourceService.getMessage(MessageKey.ADMIN_CREATE_ERROR));
				}
			}
		}
		return new FailedResult(messageSourceService.getMessage(MessageKey.ADMIN_ALREADY_CREATED));
	}

}
