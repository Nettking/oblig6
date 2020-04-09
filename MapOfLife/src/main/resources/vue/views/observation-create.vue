<template id="observation-create" @observation-submitted="addObservation">
    <div class="form-style">
        <h2>Create new Observation</h2>
        <form class="create" @submit="checkForm" :action=`/api/observations/${observationId}/createObservation` method="post">
            <div v-if="errors.length">
                <b>Please correct the following error(s):</b>
                <ul>
                    <li v-for="error in errors">{{ error }}</li>
                </ul>
            </div>

            <p>
                <label for="name">Observation name<label>
                <input type="text" name="observationName" id="observationName" v-model="observationName">
            </p>

            <p>
                <label for="planetName">Planet name<label>
                <input type="text" name="planetName" id="planetName" v-model="planetName">
            </p>

            <p>
                <label for="latitude">Latitude<label>
                <input type="number" step="0.000001" name="latitude" id="latitude" v-model="latitude" min="0">
            </p>

            <p>
                <label for="longitude">Longitude<label>
                <input type="number" step="0.000001" name="longitude" id="longitude" v-model="longitude" min="0">
            </p>

            <p>
                <label for="date">Date<label>
                    <input type="date" name="date" id="date" v-model="date" min="2337-01-01">
            </p>

            <p>
                <label for="time">Time<label>
                    <input type="time" name="time" id="time" v-model="time">
            </p>

            <p>
                <label for="numberOfObservations">Number observed<label>
                <input type="numberOfObservations" step="1" name="numberOfObservations" id="numberOfObservations" v-model="numberOfObservations" min="0">
            </p>


            <p>
                <label for="pictureUrl">Picture Url<label>
                    <input type="url" name="pictureUrl" id="pictureUrl" v-model="pictureUrl">
            </p>

            <p>
                <label for="comment">Comment<label>
                <input type="text" name="comment" id="comment" v-model="comment">
            </p>

            <p>
                <label for="commonName">Animal common name<label>
                <input type="text" name="commonName" id="commonName" v-model="commonName">
            </p>

            <p>
                <label for="scientificName">Animal scientific name<label>
                <input type="text" name="scientificName" id="scientificName" v-model="scientificName">
            </p>

            <p>
                <label for="animalType">Animal Type<label>
                    <select @change="onChangeAnimalType($event)" name="animalType" id="animalType" v-model="animalType">
                        <option value="amphibian">Amphibian</option>
                        <option value="bird">Bird</option>
                        <option value="invertebrate">Invertebrate</option>
                    </select>
            </p>

            <p v-if="animalType ==='bird'">
                <label for="canFly">Can fly<label>
                <input type="checkbox" name="canFly" id="canFly" v-model="canFly">
                <label for="canFly">Is diurnal?<label>
                <input type="checkbox" name="isDiurnal" id="isDiurnal" v-model="isDiurnal">
            </p>

            <p v-if="animalType ==='amphibian'">
                <p>
                    <label for="haveTail">Have Tail<label>
                    <input type="checkbox" name="haveTail" id="haveTail" v-model="haveTail">
                </p>
                <p>
                    <label for="numberOfLegs">Number observed<label>
                    <input type="numberOfLegs" step="1" name="numberOfLegs" id="numberOfLegs" v-model="numberOfLegs" min="0">
                </p>
            </p>

            <p v-if="animalType ==='invertebrate'">
                <label for="haveCoelom">Have coelom?<label>
                <input type="checkbox" name="haveCoelom" id="haveCoelom" v-model="haveCoelom">
            </p>




            <p>
                <input type="submit" value="Create Observation">
            </p>

        </form>
    </div>

</template>
<script>
    Vue.component("observation-create", {
        template: "#observation-create",
        data: () => ({
            name: null,
            mass: null,
            radius: null,
            semiMajorAxis: null,
            eccentricity: null,
            orbitalPeriod: null,
            planetSystemName: null,
            pictureUrl: null,
            errors: []
        }),
        created() {
            this.planetSystemName = this.$javalin.pathParams["planet-system-id"];
        },
        methods:{
            checkForm:function(e) {
                const urlRegex = "/^(?:(?:(?:https?|ftp):)?\\/\\/)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\\.(?:[a-z\u00a1-\uffff]{2,})))(?::\\d{2,5})?(?:[/?#]\\S*)?$/i";
                if(this.name && this.mass && this.radius) return true;
                this.errors = [];
                if (!this.name) this.errors.push("Name required");
                if (!this.mass) this.errors.push("Mass required");
                if (!this.radius) this.errors.push("Radius required");
                e.preventDefault();
            }
        }
    });
</script>
<style>
    .form-style{
        font-family: 'Open Sans Condensed', arial, sans;
        width: 500px;
        padding: 30px;
        background: #191919;
        margin: 50px auto;
        box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
        -moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
        -webkit-box-shadow:  0px 0px 15px rgba(0, 0, 0, 0.22);
        border: #dddddd;
    }
    .form-style h2{
        background: #4D4D4D;
        text-transform: uppercase;
        font-family: 'Open Sans Condensed', sans-serif;
        color: #FFFFFF;
        font-size: 18px;
        font-weight: 100;
        padding: 20px;
        margin: -30px -30px 30px -30px;
    }
    .form-style input[type="text"],
    .form-style input[type="date"],
    .form-style input[type="datetime"],
    .form-style input[type="email"],
    .form-style input[type="number"],
    .form-style input[type="search"],
    .form-style input[type="time"],
    .form-style input[type="url"],
    .form-style input[type="password"],
    .form-style textarea,
    .form-style select
    {
        box-sizing: border-box;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        outline: none;
        display: block;
        width: 100%;
        padding: 7px;
        border: none;
        color: white;
        border-bottom: 1px solid #ddd;
        background: transparent;
        margin-bottom: 10px;
        font: 16px Arial, Helvetica, sans-serif;
        height: 45px;
    }
    .form-style textarea{
        resize:none;
        overflow: hidden;
    }
    .form-style input[type="button"],
    .form-style input[type="submit"]{
        background: none;
        display: inline-block;
        cursor: pointer;
        font-family: 'Open Sans Condensed', sans-serif;
        font-size: 14px;
        text-decoration: none;
        text-transform: uppercase;
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
    }
    .form-style input[type="button"]:hover,
    .form-style input[type="submit"]:hover {
        border: 2px solid white;
    }

    .create {
        color: white;
    }
</style>
