const withMDX = require('@zeit/next-mdx')({
    extension: /\.mdx?$/
})
const withOffline = require('next-offline')
const withOptimizedImages = require('next-optimized-images');


//const path = require('path');
//const fs = require('fs');

//const MonacoWebpackPlugin = require('monaco-editor-webpack-plugin');
//const MONACO_DIR = path.resolve(__dirname, './node_modules/monaco-editor');
//const monacoCss = {
//                    test: /\.css$/,
//                    include: MONACO_DIR,
//                    use: ['style-loader', 'css-loader'],
//                  }

config = {
    pageExtensions: ['js', 'jsx', 'md', 'mdx'],
    webpack(config, options) {
//      config.module.rules.push(monacoCss)
//      config.plugins.push(
//            new MonacoWebpackPlugin({languages: ["css"]})
//        )
      return config
    },
    exportPathMap: function() {
      // const directoryPath = path.join(__dirname, 'pages', 'blog');
      // fs.readdirSync(directoryPath)
      
      return {
        '/': { page: '/blog' },
        '/about': {page: '/about'},
        '/veha': {page: '/about'},
        '/app': {page: '/app'},
        '/app/counter': {page: '/app/counter'},
        '/app/dbgram': {page:  '/app/dbgram'},
        '/talk': {page: '/talk'},

        '/blog': {page: '/blog'},
        '/blog/blog-idea': {page: '/blog/blog-idea'},
        '/blog/nextjs-start': {page: '/blog/nextjs-start'},
        '/blog/dbgram': {page: '/blog/dbgram'},
        '/blog/100dayofcode': {page: '/blog/100dayofcode'}
      };
    }
}
module.exports = withOptimizedImages(withOffline(withMDX(config)))
