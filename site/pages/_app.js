import React from 'react'
import Head from 'next/Head'
import App, { Container } from 'next/app'
import Link from 'next/link';
import { withRouter } from 'next/router';

const Nav_item = withRouter(({name, link, router: {pathname}}) => {
  const mainPath = pathname.split("/")[1]
  return (
  <Link href={"/" + (link || name)} prefetch>
    <div className={mainPath === (link || name) && "active"}>
      <h1>
        {name}
      </h1>
      <style jsx>{`
      div {
            flex:1;
            cursor: pointer;
            text-align: center;
            list-style:none;
            letter-spacing: .1em;
            text-shadow: 0px 3px 1px rgba(0,0,0,0.1),
                    2px 4px 1px rgba(0,0,0,0.05),
                    -2px 4px 1px rgba(0,0,0,0.05);
            -webkit-transition: all 0.5s ease-out;
            -moz-transition:    all 0.5s ease-out;
            -ms-transition:     all 0.5s ease-out;
            -o-transition:      all 0.5s ease-out;
          }
      div:hover {
        text-shadow: 0px 6px 2px rgba(0,0,0,0.1),
                    4px 8px 2px rgba(0,0,0,0.05),
                    -4px 8px 2px rgba(0,0,0,0.05);
      }
      .active {
        color: #E14F71;

        text-shadow: 0px 6px 2px rgba(0,0,0,0.1),
                    4px 8px 2px rgba(0,0,0,0.05),
                    -4px 8px 2px rgba(0,0,0,0.05);
      }    
        `}</style>
      </div>
  </Link>)})

const Nav = () => (<nav>
    <Nav_item name="blog" />
    <Nav_item name="app" />
    <Nav_item name="talk" />
    <Nav_item name="veha" link="about"/>
    <style jsx>{`
      nav {
        display: flex;
        justify-content: space-evenly;
        list-style:none;
      }
    `}</style>
</nav>)
class MyApp extends App {
  static async getInitialProps({ Component, ctx }) {
    let pageProps = {}

    if (Component.getInitialProps) {
      pageProps = await Component.getInitialProps(ctx)
    }

    return { pageProps }
  }

  render() {
    const { Component, pageProps } = this.props

    return (
      <Container>
        <Head>
          <title>Veha blog</title>
        </Head>
        <Nav />
        <div className="ctw">
          <div>
           <Component {...pageProps} className="content" />
          </div>
        </div>
        <style jsx>{`
          .ctw {
            display: flex;
            align-items: center;
            // background-color: red;
            justify-content: center;
          }
          @media (min-width: 800px) {
            .ctw div {
                max-width: 800px;
                width: 800px;
                // background-color: green;
            }
          }
          .ctw div {

          }
          `}</style>
      </Container>
    )
  }
}

export default MyApp