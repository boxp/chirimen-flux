(ns chirimen-flux.prod
  (:require [chirimen-flux.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
