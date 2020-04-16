let proxyObj = {};
require("compression-webpack-plugin");
//请求代理到哪儿去
proxyObj['/im'] = {
  ws: true,
  target: "ws://localhost:8080"
};
proxyObj['/'] = {
  ws: false,
  target: 'http://localhost:8080',
  changeOrigin: true,
  pathRewrite: {
    '^/': ''
  }
};
//开发模式的访问端口
module.exports = {
  devServer: {
    host: 'localhost',
    port: 8081,
    proxy: proxyObj
  },
  productionSourceMap: true
}
