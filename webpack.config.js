const MiniCssExtractPlugin = require('mini-css-extract-plugin');
//const ExtractTextPlugin = require('extract-ttext-webpack-plugin');
const path = require('path');
const resources = './src/main/resources/';
const templates = resources + 'templates/';
const mode = process.env.NODE_ENV || 'development';
const prod = mode === 'production';

const sassOptions = {
	includePaths: [ './node_modules', templates + 'theme' ],
};
// const extractPlugin = new ExtractTextPlugin({
// 	filename: 'minty.css'
// });

module.exports = {
	entry: {
		bundle: [
			'@webcomponents/custom-elements',
			 templates + 'MintyClientApp.js' 
			],
	},
	resolve: {
		alias: {
			svelte: path.resolve('node_modules', 'svelte'),
		},
		extensions: [ '.mjs', '.js', '.svelte' ],
		mainFields: [ 'svelte', 'browser', 'module', 'main' ],
	},
	// output: {
	// 	filename: 'minty.js',
	// },
	output: {
		path: __dirname + resources + 'public',
		filename: '[name].js',
		chunkFilename: '[name].[id].js',
		// publicPath: '/dist',
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
			//			 {
			//			 	test: /\.css$/,
			//			 	use: [
			//			 		/**
			//			 		 * MiniCssExtractPlugin doesn't support HMR.
			//			 		 * For developing, use 'style-loader' instead.
			//			 		 * */
			//			 		prod ? MiniCssExtractPlugin.loader : 'style-loader',
			//			 		'css-loader'
			//			 	]
			//			 },
			{
				test: /\.js$/,
				exclude: /(node_modules)/,
				use: {
					loader: 'babel-loader',
					// options: {
					// 	presets: [ 'es2015' ],
					// },
				},
			},
			{
				test: /\.(sa|sc|c)ss$/,
				use: [
					'style-loader',
					MiniCssExtractPlugin.loader,
					'css-loader',
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
		new MiniCssExtractPlugin({
			filename: '[name].css',
		}),
	],
	performance: {
		maxEntrypointSize: 1024000,
		maxAssetSize: 1024000,
	},
	devtool:
		prod ? false :
		'source-map',
};
