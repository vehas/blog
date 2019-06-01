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
          <link rel="manifest" href="/static/manifest.json" />
          <link rel="icon" sizes="192x192" href="/static/favicon.png" />
          <link rel="apple-touch-icon" href="/static/favicon.png" />
          <meta name="msapplication-square310x310logo" content="/static/favicon.png" />
          <meta name="Description"
                content="veha suwatphisankij personal blog, idea, app" />
          <meta name="theme-color" content="#9EE493"></meta>
          <meta charSet="utf-8" />
          {/* <title> veha blog </title> */}
          <link rel="shortcut icon" type="image/png" href="/static/favicon.png" />
          <style>{`body {
                      margin: 0;
                      padding: 0;
                      background-color: #EAFFF4;
                      color: #101010;
                      font-family: Sarabun; }
                   h1,h2,h3,h4 {
                          font-family: Prompt;  }`}</style>
          {/* <link href="https://fonts.googleapis.com/css?family=Inconsolata|Prompt:300|Sarabun:100&display=swap" rel="stylesheet"> */}

          {/* </link> */}
        </Head>
        <body className="custom_class">
          <Main />
          <NextScript />
          {/* <script src="/static/custom.js" defer></script>> */}
        </body>
      </Html>
    );
  }
}
