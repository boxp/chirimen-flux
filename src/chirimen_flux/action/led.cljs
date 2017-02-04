(ns chirimen-flux.action.led
  (:require [chirimen-flux.const :as const]
            [chirimen-flux.store.core :refer [dispatch]]))

(defn toggle-led-fx
  [gpio-access led]
  (let [port (.. gpio-access -ports (get (:pin led)))
        out (if (:blink? led) 1 0)]
    (-> (.export port "out")
        (.then #(.write port out)))))

(defn toggle-led
  [led]
  (let [new-led (update led :blink? not)]
    (-> (js/navigator.requestGPIOAccess)
        (.then (fn [gpio-access]
                 (toggle-led-fx gpio-access led)
                 (dispatch {:led new-led}))))))
