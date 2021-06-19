(ns pf-tv-430-solution.core-test
  (:require [clojure.test :refer :all]
            [pf-tv-430-solution.core :refer :all]))

(deftest test-on-example-for-fast
  (testing "test as example for fast calc"
    (are [exp result] (= exp result)
      (new-number-fast? 789) true ;=> true
      (new-number-fast? 645) false ;=> false
      (new-number-fast? 444) true))) ;=> true ))))

(deftest test-on-example
  (testing "test as example"
    (are [exp result] (= exp result)
      (new-number? 789) true ;=> true
      (new-number? 645) false ;=> false
      (new-number? 444) true))) ;=> true ))))