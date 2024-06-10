<template>
    <div class="music-player">
      <audio ref="audio"></audio>
      <button @click="play">播放</button>
      <button @click="pause">暂停</button>
      <button @click="stop">停止</button>
    </div>
  </template>
  
  <script>
  export default {
    methods: {
      play() {
        this.$refs.audio.play();
      },
      pause() {
        this.$refs.audio.pause();
      },
      stop() {
        this.$refs.audio.pause();
        this.$refs.audio.currentTime = 0;
      },
    },
  };
  </script>
  
  <style scoped>
  .music-player {
    display: flex;
    justify-content: center;
    align-items: center;
  }
  button {
    margin: 0 10px;
  }
  </style>
  