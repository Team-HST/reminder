module.exports = {
  publicPath: '',
  devServer: {
		proxy: {
			'/api': {
        target: process.env.VUE_APP_REMINDER_SERVICE_API_URL,
        changeOrigin: true,
        pathRewrite: {'^/api': ''}
			}
		}
	},
  transpileDependencies: [
    'vuetify'
  ]
}