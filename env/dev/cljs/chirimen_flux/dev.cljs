(ns ^:figwheel-no-load chirimen-flux.dev
  (:require [chirimen-flux.start :as start]
            [figwheel.client :as figwheel :include-macros true]))

(enable-console-print!)

(figwheel/watch-and-reload
  :websocket-url "ws://localhost:3449/figwheel-ws"
  :jsload-callback start/mount-root)

(start/init!)
