(ns chirimen-flux.action.core
  (:require [chirimen-flux.const :as const]
            [chirimen-flux.store.core :refer [dispatch map->LED]]))

(defn init-db []
  (-> (.all js/Promise #js[(js/navigator.requestI2CAccess)])
      (.then (fn [res]
               (let [i2c-access (aget res 0)]
                 (dispatch {:led (map->LED {:pin const/LED_PIN
                                            :blink? true})
                            :servo (map->Servo {:angle 10
                                                :min-pulse 0.0005
                                                :max-pulse 0.0024
                                                :angle-range 180
                                                :slave (.. i2c-access -ports (get const/SERVO_PORT) (open const/SERVO_SLAVE_ADDRESS))})
                            :i2c-access i2c-access}))))))
