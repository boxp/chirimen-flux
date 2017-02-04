(ns chirimen-flux.store.core
  (:require [reagent.core :as reagent]))

(defrecord LED
  [pin blink?])

(defrecord Servo
  [angle port min-pulse max-pulse angle-range])

(defrecord DB
  [led])

(defonce db
  (reagent/atom
    (map->DB {:led (map->LED {:pin 0
                              :blink? false})
              :servo (map->Servo {:angle 0
                                  :port 0
                                  :min-pulse 0
                                  :max-pulse 0
                                  :angle-range 0
                                  :slave-address 0})
              :i2c-access nil})))

(defn reducer
  [db action]
  (merge db action))

(defn debug
  [old-state new-state action]
  (js/console.group)
  (println "state: " old-state)
  (println "action: " action)
  (println "new state: " new-state)
  (js/console.groupEnd))

(defn dispatch
  [action]
  (let [s (reducer @db action)]
    (debug @db s action)
    (reset! db s)))
