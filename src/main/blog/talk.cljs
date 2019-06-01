(ns blog.talk
  (:require
   [reagent.core :as r]
   [shadow.next-js :as sn]
   ["next/link" :default Link]))

(defn youtube-wrap [video-id]
  [:div {:style {:min-width 320
                 :flex 2
                 :position "relative"
                 :padding-bottom "56.25%"
                 :padding-top  "25px"
                 :height 0}}
   [:iframe { ;:width "560"
                    ;:height "315"
                    :style {:position "absolute"
                            :top 0
                            :left 0
                            :width "100%"
                            :height "100%"
                            :margin 0
                            :padding 0}
                    :src (str "https://www.youtube.com/embed/" video-id)
                    :frame-border "0"
                    :allow "accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                    :allow-full-screen true}]])
(defn react-bkk-2018 []
  [:div {:style {:display "flex"
                 :flex-wrap "wrap"
                 :flex-direction "row"
                 :padding-bottom "20px"}}
   [:div {:style {:flex 1 :min-width 300}}
    [:p "งานนี้ได้มีโอกาสไปเล่าเรื่อง clojurescript
            ให้ react community ในไทยฟังเลยครับ"]
    [:p "งานสนุกมาก"]
    [:p "ไปเล่าว่าเทียบกันแล้ว redux กับ re-frame เหมือนหรือต่างกันยังไงบ้าง
            แล้วคนที่ใช้ redux จะเอาไอเดียอะไรใน re-frame ไปใช้ได้บ้าง"]]
   [youtube-wrap "jC1ACITwY1g"]])
(defn senior-project []
  [:div {:style {:display "flex"
                 :flex-direction "row"
                 :flex-wrap "wrap"
                 :padding-bottom "20px"}}
    [:div {:style {:flex 1 :min-width 300}}
       [:p "โปรเจ็คเกี่ยวกับการทำให้การเขียนโปรแกรมด้วยภาษา javascript"]
       [:p "มีความ interactive เห็นผลลัพธ์ระหว่างการทำงานทันที"]]
    [youtube-wrap "3EoLVrHDyHE"]])
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

