const withMDX = require('@zeit/next-mdx')({
    extension: /\.mdx?$/
})
const withOffline = require('next-offline')

config = {
    pageExtensions: ['js', 'jsx', 'md', 'mdx'],
    webpack(config, options) {
      
      return config
    
    },
    exportPathMap: function() {
      return {
        '/': { page: '/blog' },
        '/about': {page: '/about'},
        '/veha': {page: '/about'},
        '/app': {page: '/app'},
        '/blog': {page: '/blog'},
        '/talk': {page: '/talk'},
        '/blog/blog-idea': {page: '/blog/blog-idea'}
      };
    }
}
module.exports = withOffline(withMDX(config))
