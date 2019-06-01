(ns blog.about
  (:require
   [component.profile :as comp-profile]
   [reagent.core :as r]
   [shadow.next-js :as sn]
   ["next/link" :default Link]))

(defn page-about
  {:export true
   :next/page "about"}
  [props]
  (r/as-element
    [:div
      [:h2 "about me"]
      [comp-profile/profile]]))
