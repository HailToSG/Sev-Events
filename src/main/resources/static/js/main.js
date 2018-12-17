function getIndex(list, id) {
    for (let i = 0; i<list.length; i++){
        if (list[i].id===id){
            return i;
        }
    }
    return -1;
        }

let eventApi = Vue.resource('/events{/id}');

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
    template: '<div>' +
        '<input type="button" value="Edit" @click="edit"/> ' +
        '<input type="button" value="X" @click="del"/> ' +
        '<i>({{ event.id }})</i> {{ event.type }}</div>',
    methods: {
        edit: function () {
            this.editEvent(this.event);
        },
        del: function () {
            eventApi.remove({id: this.event.id}).then(result=>{
                if(result.ok){
                    this.events.splice(this.events.indexOf(this.event), 1)
                }
            })
        }
    }
});

Vue.component('events-list', {
    data: function () {
        return {
            event: null
        }
    },
    props: ['events'],

    template: '<div>' +
        '<event-form :events ="events" :eventAttr="event"/>' +
        '<event-row v-for="event in events" :key="event.id" :event="event" ' +
        ':events="events" :editEvent="editEvent"/></div>',
    create: function () {
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
let app = new Vue({
        el: '#app',
        template: '<events-list :events="events" />',
        data: {
            events: ['']
        }
    }
);