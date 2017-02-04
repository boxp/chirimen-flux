(ns chirimen-flux.presenter.home
    (:require [reagent.core :as reagent]
              [chirimen-flux.action.led :refer [toggle-led]]
              [chirimen-flux.sub.led :refer [led]]))

(defn home-page []
  (let [led (led)]
    [:div
     [:h2 "LED"]
     [:div (str (:blink? led))]
     [:button {:on-click #(toggle-led led)}
      "Toggle"]]))
