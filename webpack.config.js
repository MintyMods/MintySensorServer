const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const path = require('path');
const resources = './src/main/resources/';
const templates = resources + 'templates/';
const mode = process.env.NODE_ENV || 'development';
const prod = mode === 'production';

const sassOptions = {
  includePaths: [
    './node_modules',
    templates + 'theme'
  ],
};

module.exports = {
	entry: {
		bundle: [templates + 'MintyClientApp.js']
	},
	resolve: {
		alias: {
			svelte: path.resolve('node_modules', 'svelte')
		},
		extensions: ['.mjs', '.js', '.svelte'],
		mainFields: ['svelte', 'browser', 'module', 'main']
	},
	output: {
		path: __dirname + resources + 'public',
		filename: '[name].js',
		chunkFilename: '[name].[id].js'
	},
	module: {
		rules: [
			{
				test: /\.svelte$/,
				use: {
					loader: 'svelte-loader',
					options: {
						emitCss: true,
						hotReload: true
					}
				}
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
		]
	},
	mode,
	plugins: [
		new MiniCssExtractPlugin({
			filename: '[name].css'
		})
	],
	devtool: prod ? false: 'source-map'
};