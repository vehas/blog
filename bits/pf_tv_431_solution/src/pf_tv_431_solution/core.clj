(ns pf-tv-431-solution.core
  (:gen-class)
  (:import (clojure.lang ExceptionInfo)))

(defn sep-recur [bstr  {:keys [group depth current-str] :as opt}]
  (println "at :"
         (vec bstr)
         opt)
  (cond
    (or (= bstr "") (= bstr nil)) group

    (= (first bstr) \()
    (do
      (sep-recur (next bstr) (-> opt
                                 (update :depth #(if % (inc %) 1))
                                 (update :current-str #(str % (first bstr))))))
    (= (first bstr) \))
    (sep-recur (next bstr) (-> opt
                               (update :depth #(if % (dec %) (throw (Exception. "wrong bracket"))))
                               (update :group #(if (zero? (dec depth))
                                                 (conj % (str current-str (first bstr)))
                                                 %))
                               (update :current-str #(if (zero? (dec depth))
                                                       ""
                                                       (str % (first bstr))))))))


(defn clusters [bstr]
  (sep-recur bstr {:group []}))

(clusters "") ;=> []
(clusters "()") ;=> ["()"]
(clusters "(())") ;=> ["(())"]
(clusters "()()()") ;=> ["()" "()" "()"]
(clusters "(()())()(())") ;=> ["(()())" "()" "(())"]