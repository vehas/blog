const withMDX = require('@zeit/next-mdx')({
    extension: /\.mdx?$/
})
module.exports = withMDX({
    pageExtensions: ['js', 'jsx', 'md', 'mdx'],
    webpack(config, options) {
      return config
    },
    exportPathMap: function() {
      return {
        '/': { page: '/' },
        '/about': {page: '/about'},
        '/blog/blog-idea': {page: '/blog/blog-idea'}
      };
    }
})