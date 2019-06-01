import Document, { Html, Head, Main, NextScript } from 'next/document';

export default class MyDocument extends Document {
  static async getInitialProps(ctx) {
    const initialProps = await Document.getInitialProps(ctx);
    return { ...initialProps };
  }

  render() {
    console.log("try to render")
    return (
      <Html lang="en">
        <Head>
          <meta name="viewport" content="width=device-width, initial-scale=1" />
          <meta name="msapplication-square310x310logo" content="/static/images/icon-192.png" />
          <meta name="Description"
                content="veha suwatphisankij personal blog, idea, app" />
          <meta name="theme-color" content="#9EE493"></meta>
          <meta charSet="utf-8" />
          <link rel="manifest" href="/static/manifest.json" />
          <link rel="icon" sizes="192x192" href="/static/images/icon-192.png" />
          <link rel="apple-touch-icon" href="/static/images/favicon.png" />
          <link rel="shortcut icon" type="image/png" href="/static/images/favicon.png" />
          <style>{`
          body {
                margin: 0;
                padding: 0;
                background-color: #EAFFF4;
                color: #101010;
                font-display: swap;
                font-family: Sarabun; }
          h1,h2,h3,h4 {
                font-family: Prompt;
                font-display: swap;
              }
          a {
                color: green;
                display: inline;
                text-decoration: none;
                background-image: linear-gradient(transparent, transparent),
                                  linear-gradient(transparent, transparent),
                                  linear-gradient(142deg, #30e8bf, #D2F2CD);
                background-repeat: no-repeat;
                background-position: 120%, 122%, 0 130%;
                background-size: 100% 7px;
          }
          a:hover {
            font-weight:bold;
            transform: translateY(0);
            transition: transform .25s ease-out;
         }
          a:visited{
              color: #22548C;
          }
                          `}</style>
  
        </Head>
        <body className="custom_class">
          <Main />
          <NextScript />
          <script src="/static/custom.js" defer></script>
        </body>
      </Html>
    );
  }
}
