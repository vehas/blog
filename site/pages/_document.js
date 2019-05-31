import Document, { Html, Head, Main, NextScript } from 'next/document';

export default class MyDocument extends Document {
  static async getInitialProps(ctx) {
    const initialProps = await Document.getInitialProps(ctx);
    return { ...initialProps };
  }

  render() {
    console.log("try to render")
    return (
      <Html>
        <Head>
          {/* <title>
              veha blog
          </title> */}
          <style>{`body { background-color: #EAFFF4;
                          font-family: Sarabun; }
                   h1,h2,h3,h4 {
                          font-family: Prompt;  }`}</style>
          <link href="https://fonts.googleapis.com/css?family=Inconsolata|Prompt:300|Sarabun:100&display=swap" rel="stylesheet">

          </link>
        </Head>
        <body className="custom_class">
          <Main />
          <NextScript />
        </body>
      </Html>
    );
  }
}
