(ns pf-tv-430-solution.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn new-number-fast? [num]
  (let [n? (->> (str num)
               (map (fn [n]
                      (Integer. (str n))))
               (apply <=))]
    n?))

(defn permutation-sort* [num-vec]
  (if (= (count num-vec) 1)
      (list num-vec)
      (for [head  num-vec
            perm    (permutation-sort* (disj (apply sorted-set num-vec) head))]
          (cons head perm))))

(def permutation-sort (comp permutation-sort* sort))
(permutation-sort '(1 3 2 1))

(defn new-number? [num]
  (let [perm (->> (str num)
                  (map #(Integer. (str %)))
                  (dedupe)
                  (permutation-sort))]
    (print (str/join "" (first perm))
           (str/join "" (dedupe (str num))))
    (= (str/join "" (dedupe (str num)))
       (str/join "" (first perm)))))

(new-number? 645)
(new-number? 444)

(defn remove-head [num-vec head]
  (let [head-pos (ffirst (filter #(= (second %) head)
                                 (map-indexed #(-> [%1 %2]) num-vec)))]
    (print head-pos (take head-pos num-vec) (drop head-pos num-vec))
    (concat (take head-pos num-vec) (drop (inc head-pos) num-vec))))

(comment
  (remove-head '(1 2 1 0 0 1 2) 2))
