<script>

export default {
    beforeCreate() {
        document.querySelector('body').setAttribute('style', 'background: #FFFBE9')
    },
    beforeUnmount() {
        document.querySelector('body').setAttribute('style', '')
    },
    data() {
        return {
            anime: null,

        }
    },
    mounted() {
    },
    computed: {
    },
    methods: {
        goToAnimes() {
            this.$router.push('/anime');
        },

        goToMangas() {
            this.$router.push('/manga');
        },
        goToLogin() {
            this.$router.push('/login');
        }
    },
}
</script>

<template>
    <div>
        <ul>
            <li><a class="active" href="../">Accueil</a></li>
            <li><a href="/anime">Animes</a></li>
            <li><a href="/manga">Mangas</a></li>
            <li><a href="/login">Connexion</a></li>
            <li><a href="/profile">Profil</a></li>
            <li class="titlePage">À-propos</li>
        </ul>
    </div>

    <div>
        <div class="titleBox">
            <h1 class="mainTitle">À-propos.</h1>
            <p>GoodoOtaku est un site de critiques sur les mangas et animes.
                <br>
                Ce site à été créé dans le but d'un projet fourni par notre école, H3Hitema.
                <br>
                Les développeurs s'étant occupé du backend sont : Roberto JUSTINO et Julien PARROT.
                <br>
                Ceux s'étant occupé de la partie frontend sont : Melvin CRENIER et Guillaume DE CADOUDAL.
                <br>
                Les technologies utilisées sont Java Sprint et VueJS.
                <br>
                Notre application est déployée grâce à Heroku.
            </p>
        </div>
    </div>

</template>

<style scoped>
.mainTitle {
    color: black;
    font-family: 'Helvetica Neue', sans-serif;
    font-size: 100px;
    font-weight: bold;
    letter-spacing: -1px;
    line-height: 1;
    text-align: center;
}

ul {
    list-style-type: none;
    position: fixed;
    width: 100%;
    top: 0;
    margin: 0;
    padding: 0px;
    overflow: hidden;
    background-color: #E3CAA5;
}

li {
    float: left;
    border-right: 1px solid #FFFBE9;
}

li a {
    display: block;
    color: black;
    font-size: 20px;
    text-align: center;
    padding: 10px 20px;
    text-decoration: none;
    font-family: 'Helvetica Neue', sans-serif;
}

.active {
    background-color: #AD8B73;
    color: black;
}

li a:hover {
    background-color: #FFFBE9;
    color: black;
}

.titlePage {
    font-weight: bold;
    display: block;
    color: black;
    font-size: 20px;
    text-align: center;
    padding: 10px 20px;
    text-decoration: none;
    font-family: 'Helvetica Neue', sans-serif;
}
</style>
