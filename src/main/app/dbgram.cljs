(ns app.dbgram
  (:require
    [re-frame.core :as f]
    [reagent.core :as r]
    ["react-simple-code-editor" :default editor]
    ["react-draggable" :default drag]
    [app.dbgram.parser :as parser]))


(def code-val (r/atom parser/table-basic))

(defn table [{:keys [table-name column]}]
  (print ::taa table-name column)
  ;[:a])
  [:div {:style {:background-color "gray"
                 :width 100}}
   [:div {:style {:background-color "yellow"}}
      (str ":> " table-name)]
   (for [[name type] column]
     ^{:key name}
     [:div
      [:span (str name "---" type)]])])

(defn drag-table [table-info]
  ;[:> drag {}
  ; (r/as-element [:a])
   [table table-info])
;[table table-data]])
(defn main []
  (let [code @code-val
        tables-data  (parser/gen-table code)]
    (js/console.log ::t tables-data)
    [:div
     [:h1 "start dbgram using re-frame"]
     [:div {:style {:display "flex"
                    :width 500
                    :background-color "pink"}}
      [:div {:style {:background-color "red"
                     :height 300
                     :overflow-x "scroll"
                     :flex 1
                     :width 300}}

       [:> editor
           {:style {:background-color "green"
                    ;:rows 20
                    ;:overflow-x "scroll"
                    :white-space "nowrap"
                    :font-family "inconsolata"}
            :value code
            :onValueChange (fn [new-code]
                             ;(print new-code)
                             ;(print (parser/parse new-code))
                             (reset! code-val new-code))
            :highlight (fn [code]
                         (print ::c code)
                         code)}]]
      [:div {:style {:flex 2}}
       (->> tables-data
            (map drag-table))]]]))
       ;[:> drag {}
       ;    (r/as-element
       ;      [:div
       ;       [table {:table-name "t2-nam"
       ;               :column [["c2-3" "int"]
       ;                        ["c2-2" "string"]]}]])]]]]))


(defn mount-root []
  (f/clear-subscription-cache!)
  (r/render [main]
            (.getElementById js/document "app")))

(defn ^:export init []
  ;(f/dispatch-sync [:initialize-db])
  ;(routes/app-routes re-frame/dispatch)
  (mount-root))