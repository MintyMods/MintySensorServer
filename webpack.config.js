const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const autoprefixer = require('autoprefixer');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const FriendlyErrorsWebpackPlugin = require('friendly-errors-webpack-plugin');

const path = require('path');
const dist = path.resolve('../MintyMods.info/demo');
const resources = './src/main/resources/';
const templates = resources + 'templates/';
const mode = process.env.NODE_ENV || 'development';
const prod = mode === 'production';
const app = 'minty-sensor-server';

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
	entry: {
		bundle: [ templates + 'MintyClientApp.js' ],
	},
	resolve: {
		alias: {
			svelte: path.resolve('node_modules', 'svelte'),
		},
		extensions: [ '.mjs', '.js', '.svelte' ],
		mainFields: [ 'svelte', 'browser', 'module', 'main' ],
	},
	output: {
		path:
			prod ? dist :
			path.resolve(__dirname, resources + 'public'),
		filename: app + '.js',
		chunkFilename: app + '.[id].js',
	},
	module: {
		rules: [
			{
				test: /\.svelte$/,
				use: {
					loader: 'svelte-loader',
					options: {
						emitCss: true,
						hotReload: true,
					},
				},
			},
			{
				test: /\.js$/,
				exclude: /(node_modules)/,
				use: {
					loader: 'babel-loader',
					options: {
						presets: [ [ '@babel/preset-env' ] ],
					},
					// options: {
					// 	presets: [ 'es2015' ],
					// },
				},
			},
			{
				test: /\.(sa|sc|c)ss$/,
				use: [

						prod ? MiniCssExtractPlugin.loader :
						'style-loader',
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
									prod && require('cssnano')({ preset: 'default' }),
								].filter(Boolean),
						},
					},
					{
						loader: 'sass-loader',
						options: sassOptions,
					},
				],
			},
		],
	},
	mode,
	plugins: [
		//new CleanWebpackPlugin({ verbose: false }),
		new FriendlyErrorsWebpackPlugin(),
		new MiniCssExtractPlugin({
			filename: app + '.css',
		}),
		new CopyWebpackPlugin([ { from: resources + 'static', to: dist }, { from: templates + 'public', to: dist } ]),
	],
	performance: {
		maxEntrypointSize: 1024000,
		maxAssetSize: 1024000,
	},
	devtool:
		prod ? false :
		'source-map',
};
