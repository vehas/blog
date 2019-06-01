(ns blog.app
  (:require
   [app.counter :as counter]
   [reagent.core :as r]
   [shadow.next-js :as sn]
   [component.link :as link]))


(defn counter
  {:export true
   :next/page "app/counter"}
  [props]
  (r/as-element
    [counter/main]))


(defn page-app
  {:export true
   :next/page "app"}
  [props]
  (r/as-element
   [:div
    [:h1 "app"]
    ; [counter-component]
    [link/link "แอพ counter" "/app/counter"]]))

