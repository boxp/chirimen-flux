(ns chirimen-flux.start
    (:require [chirimen-flux.action.core :refer [init-db]]
              [chirimen-flux.presenter.home :refer [home-page]]
              [reagent.core :as reagent]))

(enable-console-print!)

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn start []
  (init-db)
  (mount-root))

(js/window.addEventListener "load" start)
