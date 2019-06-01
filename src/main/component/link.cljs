(ns component.link
  (:require
    ["next/link" :default Link]))

(defn link [title link]
  [:div {:style {:padding 10
                 :margin 5}}
   [:> Link
    {:href link}
    [:a title]]])
