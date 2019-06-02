(ns blog.blog
  (:require
   [reagent.core :as r]
   [shadow.next-js :as sn]
   [component.link :as link] 
   [component.profile :as comp-profile]))
(defn page-about
  {:export true
   :next/page "blog"}
  [props]
  (r/as-element
    [:div
     [:h1 "สวัสดีชาวโลก"]
     [comp-profile/profile]
     [link/link "มาลองใช้ nextjs กับ clojurescript กันเถอะ"  "/blog/nextjs-start"]
     [link/link "ไอเดียเริ่มต้นของบล้อกนี้" "/blog/blog-idea"]
     [link/link "dbgram ตัวช่วยทำ database schema" "/blog/dbgram"]
     [link/link "100 days of code มาเขียน code 100 วันต่อเนื่องกัน" "/blog/100dayofcode"]]))
     
