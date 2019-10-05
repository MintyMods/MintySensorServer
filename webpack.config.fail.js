const app = 'minty-sensor-server';
const path = require('path');
const dist = path.resolve('../MintyMods.info/demo');
const resources = './src/main/resources/';
const templates = resources + 'templates/';
const webpack = require('webpack');
const autoprefixer = require('autoprefixer');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const FriendlyErrorsWebpackPlugin = require('friendly-errors-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const mode = process.env.NODE_ENV || 'development';
const isDev = mode === 'development';
const sassOptions = {
	includePaths: [ './node_modules', templates + 'theme' ],
};
const babelLoader = {
	loader: 'babel-loader',
	options: {
		presets: [ [ '@babel/preset-env' ] ],
	},
};

module.exports = {
	mode,
	entry: path.resolve(__dirname, templates + 'MintyClientApp.js'),
	// resolve: {
	// 	alias: {
	// 		svelte: path.resolve('node_modules', 'svelte'),
	// 	},
	// 	extensions: [ '.mjs', '.js', '.svelte' ],
	// 	mainFields: [ 'svelte', 'browser', 'module', 'main' ],
	// },
	output: {
		path:
			isDev ? path.resolve(__dirname, resources + 'public') :
			dist,
		filename: app + '.js',
		chunkFilename: '[id].js',
	},
	devServer: {
		quiet: true,
	},
	module: {
		rules: [
			{
				test: /\.(html|svelte)$/,
				use: [
					babelLoader,
					{
						loader: 'svelte-loader',
						options: {
							emitCss: true,
							legacy: true,
							hotReload: true,
						},
					},
				],
			},

			{
				test: /\.m?js$/,
				exclude: /node_modules\/(?!svelte)/,
				use: babelLoader,
			},

			{
				test: /\.css$/,
				use: [

						isDev ? 'style-loader' :
						MiniCssExtractPlugin.loader,
					{
						loader: 'css-loader',
					},
					{
						loader: 'postcss-loader',
						options: {
							ident: 'postcss', // https://webpack.js.org/guides/migrating/#complex-options
							plugins: () =>
								[
									require('postcss-flexbugs-fixes'),
									autoprefixer({
										flexbox: 'no-2009',
									}),
									// Only minify CSS in production.
									!isDev && require('cssnano')({ preset: 'default' }),
								].filter(Boolean),
						},
					},
				],
			},
			{
				test: /\.(sa|sc|c)ss$/,
				exclude: /node_modules/,
				use: [
					{
						loader: 'sass-loader',
						options: sassOptions,
					},
				],
			},
			{
				loader: 'file-loader',
				exclude: /\.(js|ejs|json)$/,
				options: {
					name: 'static/[name].[hash:8].[ext]',
				},
			},
		],
		// 	},
		// ],
	},
	plugins: [
		!isDev && new CleanWebpackPlugin({ verbose: false }),
		new FriendlyErrorsWebpackPlugin(),
		new webpack.EnvironmentPlugin({
			NODE_ENV: 'development', // Use 'development' unless process.env.NODE_ENV is defined.
		}),
		!isDev &&
			new MiniCssExtractPlugin({
				filename: app + '.[hash:8].css',
			}),
		!isDev && new CopyWebpackPlugin([ 
			{ from: resources + 'static', to: dist },
			{ from: templates + 'public', to: dist }
		]),
	].filter(Boolean),
	performance: {
		maxEntrypointSize: 1024000,
		maxAssetSize: 1024000,
	},
};
