(ns app.dbgram
  (:require
    [re-frame.core :as f]
    [reagent.core :as r]))


(defn main []
  [:div "start dbgram using re-frame"])


(defn mount-root []
  (f/clear-subscription-cache!)
  (r/render [main]
            (.getElementById js/document "app")))

(defn ^:export init []
  ;(f/dispatch-sync [:initialize-db])
  ;(routes/app-routes re-frame/dispatch)
  (mount-root))