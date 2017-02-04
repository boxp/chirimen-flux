(ns chirimen-flux.sub.led
  (:require [chirimen-flux.store.core :refer [db]]))

(defn led []
  (-> (deref db) :led))
