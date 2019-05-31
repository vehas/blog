(ns blog.about
  (:require
   [reagent.core :as r]
   [shadow.next-js :as sn]
   ["next/link" :default Link]))

(defn page-about
  {:export true
   :next/page "about"}
  [props]
  (r/as-element
    [:div "about"]))
