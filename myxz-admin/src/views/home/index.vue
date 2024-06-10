<template>
    <div class="app">
        <div class="main-box">
            <div class="left-box">
                <el-row :gutter="12">
                    <el-col :span="120">
                        <el-card shadow="hover" style="background-color: #a1858d;">
                            <div class="logo">
                                <img src="@/assets//logo/logo.png" alt="明裕学长" style="height: 300px; width: 300px;"/>
                                <h1>{{ ava }}</h1>
                            </div>
                            <div>
                                <h4>每日一言：</h4>
                                <p>{{ dailyQuote }}</p>
                            </div>
                        </el-card>
                    </el-col>
                </el-row>
            </div>
            <div class="music-box">
                <!-- <aplayer :audio="audio" :lrcType="3" /> -->
                <aplayer :audio="audio" :autoplay="true" />
                <el-card shadow="hover" style="background-color: #a1858d;">
                    <h4>网易云热评：</h4>
                    <p>
                        {{ wyyrp }}
                    </p>
                    ————网友：{{ wyyrpnick }}
                </el-card>
                <el-button @click="gotomusic">随机获取一首</el-button>
            </div>
            <div class="right-box">
                <el-card shadow="hover" style="background-color: #a1858d;">
                    <div>
                        <p>
                            <span>城市：{{ weather.city }}</span>
                        </p>
                        <p>
                            <span>天气：{{ weather.type }}</span>
                        </p>
                        <p>
                            <span>日期：{{ weather.date }}</span>
                        </p>
                        <p>
                            <span>{{ weather.week }}</span>
                        </p>
                        <p>
                            <span>最高气温：{{ weather.high }}</span>
                        </p>
                        <p>
                            <span>最低气温：{{ weather.low }}</span>
                        </p>
                        <p>
                            <span>小贴士：{{ weather.tip }}</span>
                        </p>
                    </div>
                    <p>
                        时间： {{ currentTime }}
                    </p>
                </el-card>
                <el-card shadow="hover" style="background-color: #a1858d;">
                    <h4>
                        情话：
                    </h4>
                    <p>{{ love }}</p>
                </el-card>
                <el-row :gutter="12">
                    <el-col :span="12">
                        <el-card shadow="hover" style="background-color: #a1858d;">
                            博客
                            <el-button type="text" class="button" @click="goToBlog">GO</el-button>
                        </el-card>
                    </el-col>
                    <el-col :span="12">
                        <el-card shadow="hover" style="background-color: #a1858d;">
                            后台
                            <el-button type="text" class="button" @click="goToBlogAdmin">GO</el-button>
                        </el-card>
                    </el-col>
                </el-row>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import MusicPlayer from '../../components/home/MusicPlayer.vue';

export default {
    components: {
        MusicPlayer,
    },
    data() {
        return {
            ava: '明裕学长',
            dailyQuote: '',
            wyyrp: '',
            wyyrpnick: '',
            currentTime: '',
            love: '',
            weather: {
                city: '',
                date: '',
                week: '',
                type: '',
                low: '',
                high: '',
                tip: ''

            },
            audio: {
                name: '',
                artist: '',
                url: '',
                cover: '',
                // lrc: 'https://cdn.moefe.org/music/lrc/thing.lrc',
            },

        };
    },
    methods: {
        async fetchDailyQuote() {
            // 获取每日一言
            const response = await axios.get('https://api.vvhan.com/api/ian/rand');
            this.dailyQuote = response.data;
            // 获取网易云热评
            const responsewyyrp = await axios.get('https://api.uomg.com/api/comments.163?sort=热歌榜&format=json');
            this.wyyrp = responsewyyrp.data.data.content
            this.wyyrpnick = responsewyyrp.data.data.nickname
            // 获取音乐
            const responsemusic = await axios.get('https://api.vvhan.com/api/wyMusic/热歌榜?type=json');
            this.audio.name = responsemusic.data.info.name;
            this.audio.artist = responsemusic.data.info.auther;
            this.audio.url = responsemusic.data.info.url;
            this.audio.cover = responsemusic.data.info.picUrl;
            // 获取情话
            const responselove = await axios.get('https://api.vvhan.com/api/text/love');
            this.love = responselove.data;
            // 获取天气
            const resweather = await axios.get('https://api.vvhan.com/api/weather');
            this.weather.city = resweather.data.city
            this.weather.date = resweather.data.data.date
            this.weather.week = resweather.data.data.week
            this.weather.type = resweather.data.data.type
            this.weather.low = resweather.data.data.low
            this.weather.high = resweather.data.data.high
            this.weather.tip = resweather.data.tip

            console.log(resweather);

        },

        goToBlog() {
            this.$router.push('/blog');

        },
        goToBlogAdmin() {
            this.$router.push('/login');
        },
        gotomusic() {
            this.fetchDailyQuote();
        }
    },
    mounted() {
        this.fetchDailyQuote();
        setInterval(() => {
            this.currentTime = new Date().toLocaleTimeString();
        }, 1000);
        // 获取天气和城市信息的逻辑
    },
};
</script>

<style scoped>
.app {
    border-radius: 50px;
    height: 100%;
    width: 100%;
    background: url('https://api.vvhan.com/api/wallpaper/views');
}

.main-box {
    height: 100%;
    width: 100%;
    display: flex;
    justify-content: space-around;
    align-items: center;
}


.left-box {
    height: 400px;
    width: 400px;
    text-align: center;
}

.music-box {
    height: 400px;
    width: 800px;
}

.right-box {
    height: 400px;
    width: 400px;
    text-align: center;
}
</style>