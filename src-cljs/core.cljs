(ns hububba.core
  (:require [hububba.posts :as posts]))

(defn- start [] (posts/all-posts))

(set! (.-onload js/window) start)
