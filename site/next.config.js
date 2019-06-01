const withMDX = require('@zeit/next-mdx')({
    extension: /\.mdx?$/
})
const withOffline = require('next-offline')
const withOptimizedImages = require('next-optimized-images');

const path = require('path');
const fs = require('fs');

config = {
    pageExtensions: ['js', 'jsx', 'md', 'mdx'],
    webpack(config, options) {
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

        '/talk': {page: '/talk'},

        '/blog': {page: '/blog'},
        '/blog/blog-idea': {page: '/blog/blog-idea'},
        '/blog/nextjs-start': {page: '/blog/nextjs-start'}
      };
    }
}
module.exports = withOptimizedImages(withOffline(withMDX(config)))
