(ns challange.core
  (:require [clojure.string :as s])
  (:require [clojure.set :as set]))

(def the-challange "VOCDIITEIOCRUDOIANTOCSLOIOCVESTAIOCVOLIOCENTSU")

(def the-words (map str '(TDD, DDD, DI, DO, OO, UI, ANT, CV, IOC, LOC, SU, VO)))

(defn reduce-replace [challange words]
  (let [len (count challange)
        replacements (filter #(< (count %) len) (map #(s/replace challange (re-pattern %) "") words))]
    (do
      (conj (set/union (set replacements)
                       (apply set/union (map #(reduce-replace % words) replacements)))
            challange))))

(defn solve [challange words]
  (let [comp (fn [& params] (apply < (map count params)))]
    (sort comp (reduce-replace challange words))))
