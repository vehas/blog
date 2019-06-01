(ns blog.blog
  (:require
   [reagent.core :as r]
   [shadow.next-js :as sn]
   ["next/link" :default Link]))

(defn page-about
  {:export true
   :next/page "blog"}
  [props]
  (r/as-element
    [:div
     [:h1 "Hi human!"]
     [:p "Welcome to veha blog"]
     [:> Link {:href "/blog/blog-idea"} [:a "goto idea behide this blog"]]]))
