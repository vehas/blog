(ns blog.talk
  (:require
   [reagent.core :as r]
   [shadow.next-js :as sn]
   ["next/link" :default Link]))

(defn page-about
  {:export true
   :next/page "talk"}
  [props]
  (r/as-element
   [:div
     [:h1 "talk, let's talk"]]))
