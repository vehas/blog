(ns blog.app
  (:require
   [reagent.core :as r]
   [shadow.next-js :as sn]
   ["next/link" :default Link]))

(defn page-app
  {:export true
   :next/page "app"}
  [props]
  (r/as-element
   [:div
    [:h1 "app"]]))

