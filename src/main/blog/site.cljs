(ns blog.site
  (:require
   [component.link :as link]
   [reagent.core :as r]
   [shadow.next-js :as sn]
   ["next/link" :default Link]))

(defn page-index
  {:export true
   :next/page "index"}
  [props]
  (r/as-element
    [:div
     [:h1 "Hi human!"]

     [:p "Welcome to veha blog"]
    ;  [:p "Now go build something great with ClojureScript."]
    ;  [:p "don't know what to do here ?"
        ;  [:> Link {:href "/blog-idea"} [:a " look at idea behide this blog"]]]
     [:> Link {:href "/about"} [:a "goto about"]]
     [:hr]
     [:> Link {:href "/blog/blog-idea"} [:a "goto idea behide this blog"]]]))
    ;  [:hr]
    ;  [:> Link {:href "/test"}   [:a "go  to markdown"]]]))

(defn page-index-query [req]
  (js/Promise.resolve {:hello "world"}))

(sn/add-query page-index page-index-query)

(defn page-2
  {:export true
   :next/page "page-2"}
  [props]
  (r/as-element
    [:div
     [:h1 "Hello from Page 2 hohoho"]

     [:> Link {:href "/"} [:a "back to index"]]]))
     

(defn page-404
  {:export true
   :next/page "404"}
  [props]
  (r/as-element
    [:h1 "404!"]))