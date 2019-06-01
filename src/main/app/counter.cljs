(ns app.counter
 (:require
    [reagent.core :as r]))

(def count-val (r/atom 0))

(defn main [props]
  [:<>
   [:span "เริ่มจากแอพง่าย ๆ อย่าง
          ปุ่มบวกลบ ก่อนน่ะครับ"]
   [:div {:style {:display "flex"
                  :min-height "500px"
                  :position "relative"
                  :background-color "green"}}
    [:div {:on-click #(swap! count-val inc)
           :style {:background "#E14F71"
                   :flex 1}}
     "plus, -, เพิ่มค่า"]
    [:span {:style {:position "absolute"
                    :top 0
                    :left "20%"
                    :font-display "swap"
                    :font-size 300
                    :user-select "none"}};}}
        (str  @count-val)]
    [:div {:on-click #(swap! count-val dec)
           :style {:background "#D2F2CD"
                   :flex 1}}
     "minus, -, ลดค่า"]]])
