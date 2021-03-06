(ns app.utils
  (:require [cljs.pprint :as pprint]))

(defn kilo-numbers
  "Add a comma every power of 1k"
  [number]
  (when number
    (clojure.string/replace
      number
      #"\B(?=(\d{3})+(?!\d))" ",")))

(defn format-number
  "Format a float number"
  [number]
  (kilo-numbers
    (pprint/cl-format nil "~,2f" number)))

(defn get-user-price
  "Take all currencies but only return the price the user have choosen"
  [c usd eur gbp btc]
  (case c
        "USD" usd
        "EUR" eur
        "GBP" gbp
        "BTC" btc
        "" 0))
