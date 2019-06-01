(ns component.profile)

(defn profile [back-to-main?]
  [:div {:style {:padding 10
                 :border-radius 5
                 :background-color "#D2F2CD"
                 :display "flex"}}
   [:div
    [:img {:src "/static/images/profile.jpg"
           :alt "veha-profile"
           :width 150 :height 150
           :style {:border-radius "5px"}}]]
   [:div {:style {:padding-left 10 :max-width 300}}
    [:span
     "เราชื่อเวหา เชื่อว่าการเทคโนโลยีจะส่งผลดีต่อสังคมได้มากที่สุด
     และเทคโนโลยีที่ดีจะต้องเข้า ถึงง่าย และสนุก งานหลักเป็นนักพัฒนาโปรแกรม
     ด้วยภาษา  clojure/clojurescript"]
    (when back-to-main?
          [:span "กลับไปหน้าหลัก"])]]) 
