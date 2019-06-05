(ns app.dbgram
  (:require
    [re-frame.core :as f]
    [reagent.core :as r]
    ["react-simple-code-editor" :default editor]
    ["react-draggable" :default drag]
    ["prismjs/components/prism-core" :refer [highlight, languages]]
    ["react-codemirror2" :rename {UnControlled CodeMirror}]
    ["codemirror/mode/javascript/javascript"]
    ["prismjs/components/prism-graphql"]
    ["codemirror-graphql/mode"]
    ["sql.js" :default initSqlJs]
    ;["codemirror/lib/codemirror.css"]
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
   ^{:key (:table-name table-info)}
   [table table-info])
;[table table-data]])
(defonce sql-db (atom nil))

(comment
  (let [table "CREATE TABLE hello (a int, b char);
               INSERT INTO hello VALUES (0, 'hello');
               INSERT INTO hello VALUES (1, 'world');"]
    (print (.run @sql-db table)))
  (-> @sql-db
      (.exec "select * from hello")
      (js/console.log)))
(defn sqlite []
  (let [_ (-> (initSqlJs)
              (.then (fn [sql]
                       (let [_  (js/console.log "sql : " sql)
                             db (sql.Database.)]
                         (print "db : "db)
                         (reset! sql-db db))))
              (.catch (fn [err]
                        (print "error : " err))))]
    (fn []
      [:div "db start"])))
(defn main []
  (let [code @code-val
        tables-data  (parser/gen-table code)]
    (js/console.log ::t tables-data)
    [:div
     [:h1 "start dbgram using re-frame"]
     [:div {:style {:display "flex"
                    :width 500
                    :background-color "pink"
                    :height 300}}
      [:div
       {:style {:background-color "red"
                :height 150
       ;         :overflow-x "scroll"
       ;         :flex 1
                :width 300}}

       [:> CodeMirror
           {:style {:background-color "green"
                    :border "1px solid #eee"
                    :height "auto"};}
           ;         :rows 20
           ;         :overflow-x "scroll"
                   ;:white-space "nowrap"
                   ;:font-family "inconsolata"
            :value parser/table-basic
            :options {:lineNumbers true
                      :mode "graphql"
                      :size [nil "100"]}
            :onUpdate (fn [editor update]
                        (print editor update))
            :onChange (fn [editor data value]
                        ;(print editor data value)
                        (print (parser/parse value))
                        (reset! code-val value))}]]
            ;:highlight (fn [code]
            ;             (print ::c code)
            ;             (highlight code (.-graphql languages))))]]
      [:div {:style {:flex 2}}
       (->> tables-data
            (map drag-table))]]
     [:div
      [:div "test sql js"]
      [sqlite]]]))


(defn mount-root []
  (f/clear-subscription-cache!)
  (r/render [main]
            (.getElementById js/document "app")))

(defn ^:export init []
  ;(f/dispatch-sync [:initialize-db])
  ;(routes/app-routes re-frame/dispatch)
  (mount-root))