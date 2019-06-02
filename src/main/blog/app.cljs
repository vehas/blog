(ns blog.app
  (:require
   [app.counter :as counter]
   [app.dbgram :as dbgram]
   [reagent.core :as r]
   [shadow.next-js :as sn]
   [component.link :as link]))


(defn counter-app
  {:export true
   :next/page "app/counter"}
  [props]
  (r/as-element
    [counter/main]))

(defn dbgram-app
  {:export true
   :next/page "app/dbgram"}
  [props]
  (r/as-element
    [dbgram/main]))

(defn page-app
  {:export true
   :next/page "app"}
  [props]
  (r/as-element
   [:div
    [:h1 "app"]
    ; [counter-component]
    [link/link "แอพ counter" "/app/counter"]
    [link/link "แอพ dbgram ตัวช่วยอกแบบ database ทั้ง sql และ nosql"
               "/app/dbgram"]]))

