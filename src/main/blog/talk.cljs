(ns blog.talk
  (:require
   [reagent.core :as r]
   [shadow.next-js :as sn]
   ["next/link" :default Link]))

(defn react-bkk-2018 []
  [:div {:style {:display "flex"
                 :flex-direction "row"
                 :padding-bottom "20px"}}
   [:div {:style {:width 240}}
    [:p "งานนี้ได้มีโอกาสไปเล่าเรื่อง clojurescript
            ให้ react community ในไทยฟังเลยครับ"]
    [:p "งานสนุกมาก"]
    [:p "ไปเล่าว่าเทียบกันแล้ว redux กับ re-frame เหมือนหรือต่างกันยังไงบ้าง
            แล้วคนที่ใช้ redux จะเอาไอเดียอะไรใน re-frame ไปใช้ได้บ้าง"]] 
   [:iframe {:width "560"
              :height "315"
              :src "https://www.youtube.com/embed/jC1ACITwY1g"
              :frame-border "0"
              :allow "accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
              :allow-full-screen true}]])

(defn senior-project []
  [:div {:style {:display "flex"
                 :flex-direction "row"
                 :padding-bottom "20px"}}
    [:div {:style {:width 240}}
       [:p "โปรเจ็คเกี่ยวกับการทำให้การเขียนโปรแกรมด้วยภาษา javascript"]
       [:p "มีความ interactive เห็นผลลัพธ์ระหว่างการทำงานทันที"]]
    [:iframe {:width "560"
              :height "315"
              :src "https://www.youtube.com/embed/3EoLVrHDyHE"
              :frame-border "0"
              :allow "accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
              :allow-full-screen true}]])
(defn intro []
  [:div
    [:h1 "talk หรือ กิจกรรม ที่เคยไปเข้าร่วมมาครับ"]])

(defn page-about
  {:export true
   :next/page "talk"}
  [props]
  (r/as-element
   [:div
    [intro]
    [react-bkk-2018]
    [senior-project]]))

