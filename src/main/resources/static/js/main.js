function getIndex(list, id) {
    for (let i = 0; i<list.length; i++){
        if (list[i].id===id){
            return i;
        }
    }
    return -1;
        }

let eventApi = Vue.resource('/events/{/id}');

Vue.component('event-form', {
    props: ['events', 'eventAttr'],
    data: function () {
        return {
            type: '',
            id: ''
        }
    },
    watch: {
        eventAttr: function (newVal) {
            this.type = newVal.type;
            this.id = newVal.id
        }
    },
    template: '<div>' +
        '<input type="type" placeholder="Enter an event type" v-model="type"/>' +
        '<input type="button" value="Save" @click="save"/>' +
        '</div>',
    methods: {
        save: function (data) {
            let event = {type: this.type};
            if (this.id) {
                var index = getIndex(this.events, data.id);
                eventApi.update({id: this.id,}, event).then(result =>
                    result.json().then(data => {
                        this.events.splice(index, 1, data);
                        this.type = '';
                        this.id = '';
                    }))
            } else {
                eventApi.save({}, event).then(result => result.json().then(data => {
                        this.events.push(data);
                        this.type = '';
                        this.id = '';
                    }
                ))
            }
        }
    }
});

Vue.component('event-row', {
    props: ['event', 'editEvent', 'events'],
    template: '<div><input type="button" value="Edit" @click="edit"/> <i>({{ event.id }})</i> {{ event.type }}</div>',
    methods: {
        edit: function () {
            this.editEvent(this.event);
        }
    }
});

Vue.component('event-list', {
    data: function () {
        return {
            event: null
        }
    },
    props: ['events'],

    template: '<div>' +
        '<event-form :events ="events" :eventAttr="event"/>' +
        '<event-row v-for="event in events" :key="event.id" :event="event" :editEvent="editEvent"/></div>',
    created: function () {
        eventApi.get().then(result => result.join().then(data =>
            data.forEach(event =>
                this.events.push(event())))
        )
    },
    methods: {

        editEvent: function (event) {
            this.event = event;
        }

    }
});

var app = new Vue({
        el: '#app',
        template: '<event-list :events="events" />',
        data: {
            events: []
        }
    }
);