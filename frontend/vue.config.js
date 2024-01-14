const path = require("path");

module.exports = {
  devServer: {
    proxy : 'http://localhost:8099'
  },
  indexPath: '../../templates/vue/index.html',
  publicPath: '/vue',
  outputDir: path.resolve(__dirname, "../backend/src/main/resources/static/vue")
}