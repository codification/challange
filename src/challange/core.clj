(ns challange.core
  (:require [clojure.contrib.str-utils2 :as s]))

(defn remove-from [s pattern]
  (s/replace s pattern ""0))
